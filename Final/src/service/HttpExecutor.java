package service;

import modelo.Request;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.StringEntity;
import java.util.Arrays;

public class HttpExecutor {

    public static String ejecutar(Request req) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {

            HttpRequestBase request;

            switch (req.getMethod().toUpperCase()) {
                case "GET":
                    request = new HttpGet(req.getUrl());
                    break;
                case "POST":
                    HttpPost post = new HttpPost(req.getUrl());
                    if (req.getBody() != null && !req.getBody().isEmpty())
                        post.setEntity(new StringEntity(req.getBody()));
                    request = post;
                    break;
                case "PUT":
                    HttpPut put = new HttpPut(req.getUrl());
                    if (req.getBody() != null && !req.getBody().isEmpty())
                        put.setEntity(new StringEntity(req.getBody()));
                    request = put;
                    break;
                case "DELETE":
                    request = new HttpDelete(req.getUrl());
                    break;
                default:
                    throw new IllegalArgumentException("Método HTTP no soportado: " + req.getMethod());
            }

            if (req.getHeaders() != null) {
                Arrays.stream(req.getHeaders().split("\\n")).forEach(line -> {
                    String[] kv = line.split(":", 2);
                    if (kv.length == 2) {
                        request.setHeader(kv[0].trim(), kv[1].trim());
                    }
                });
            }

            try (CloseableHttpResponse response = client.execute(request)) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : "[Respuesta vacía]";
            }

        }
    }
}
