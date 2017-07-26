public class Util {

    private static MultipartBody.Part buildPart(String path, boolean isSource) {
        String fieldName = (isSource) ? "sourceFiles" : "referenceFiles";
        MediaType octet = MediaType.parse("application/octet-stream");
        File file = new File(path);
        RequestBody fileRequestBody = RequestBody.create(octet, file);
        return MultipartBody.Part.createFormData(
                fieldName, file.getName(), fileRequestBody);
    }

    private InputStream getDownloadedFilesStream(String taskId, String type, String user) {
        return fileApi.downloadFiles(taskId, type, user).toBlocking().first().byteStream();
    }
}