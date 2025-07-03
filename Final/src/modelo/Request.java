package modelo;

import java.time.LocalDateTime;

public class Request {
    private int id;
    private int userId;
    private String method;
    private String url;
    private String headers;
    private String body;
    private String response;
    private LocalDateTime timestamp;
    private String favoriteName;

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getHeaders() { return headers; }
    public void setHeaders(String headers) { this.headers = headers; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getFavoriteName() { return favoriteName; }
    public void setFavoriteName(String favoriteName) { this.favoriteName = favoriteName; }
}
