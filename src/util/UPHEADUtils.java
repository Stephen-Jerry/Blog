package util;

import dao.userheadDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class UPHEADUtils {
    // 上传文件存储目录
    private static final String SAVE_HEAD_PATH = "D:\\blogg\\web\\userhead";
    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    /**
     * 上传数据及保存文件
     * ServletFileUpload负责处理上传的文件数据,并将表单中每个输入项封装成一个FileItem对象中，
     * 在使用ServletFileUpload对象解析请求时需要根据
     * DiskFileItemFactory对象的属性sizeThreshold（临界值）和repository（临时目录）
     * 来决定将解析得到的数据保存在内存还是临时文件中，
     * 如果是临时文件，保存在哪个临时目录中？。所以，我们需要在进行解析工作前构造好DiskFileItemFactory对象，
     * 通过ServletFileUpload对象的构造方法或setFileItemFactory()方法设置ServletFileUpload对象的fileItemFactory属性。
     */
    public static void updateHead(HttpServletRequest request, HttpServletResponse response, int id) throws Exception {
        // 检测是否为多媒体上传, isMultipartContent方法方法用于判断请求消息中的内容是否是“multipart/form-data”类型，是则返回true，否则返回false。
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        upload.setHeaderEncoding("UTF-8");

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    // 找到文件上传表单域
                    if (!item.isFormField()) {
                        File head_img = new File(item.getName());
                        String fileName = id + getSuffix(head_img);
                        String filePath = SAVE_HEAD_PATH + File.separator + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                        new userheadDao().userhead(id,"/userhead/"+fileName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "错误信息: " + e.getMessage());
        }
    }

    public static String getSuffix(File file){
        if(file == null){
            return null;
        }
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") == -1){
            return "";
        }
        return fileName.substring(fileName.lastIndexOf("."));
    }

}
