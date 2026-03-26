package projetos.springBoot.taskList.exceptions;

public class ErrorResponse {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}

/*
obs:
esta classe é utilizada para padronizar os erros da api.
transformamos o erro em um objeto java estruturado, o spring converte automaticamente para json. isso cria um padrão consistente de resposta de erro 
*/
 