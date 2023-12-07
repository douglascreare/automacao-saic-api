package creare.saic.rest.core;

import io.restassured.http.ContentType;

public interface Constantes {
     String APP_BASE_URL = "https://dv-saic-mata.crearecloud.com.br/api";
     Integer APP_PORT = 443;
     ContentType APP_CONTENT_TYPE = ContentType.JSON;
     Long MAX_TIMEOUT = 6000L;
}
