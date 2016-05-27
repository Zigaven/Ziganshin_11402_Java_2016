package sample.connection;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sample.entities.ComicsEntity;
import sample.entities.GeneralEntity;
import sample.entities.roles.Role;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ruslanzigansin on 26.05.16.
 */
public class ServerConnection {
    private final String SERVER_URL = "http://localhost:8181/rest/api/";

    public Role getUserRole() throws Exception {
        return mapper().readValue(getResponse("role"), Role.class);
    }

    public List<ComicsEntity> getComics() {
        try {
            return Arrays.asList(mapper().readValue(getResponse("comics"), ComicsEntity[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return mapper;
    }

    private String getResponse(String path) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new CustomErrorResponseHandler());
        String url = SERVER_URL + path;
        ResponseEntity resp = restTemplate.exchange(url, HttpMethod.GET, request(path), String.class);
        return resp.getBody().toString();
    }

    private void doPost(String path, Object object) {
        String url = SERVER_URL + path;
        try {
            new RestTemplate().exchange(url, HttpMethod.POST, request(object), object.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HttpEntity<String> request() throws IOException {
        return request(null);
    }

    private HttpEntity request(Object payload) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", ServerAuthentication.getLoginPass());
        return new HttpEntity(payload, headers);
    }

//
//    public List<ShopEntity> getAvailableCars() {
//        try {
//            return Arrays.asList(mapper().readValue(getResponse("shop"), CarsEntity[].class));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//

    public List<GeneralEntity> getStaff() {
        try {
            return Arrays.asList(mapper().readValue(getResponse("staff"), GeneralEntity[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }    }

    public void postNewComics(ComicsEntity comicsEntity) {
        doPost("/comics/new",comicsEntity);
    }

    public void postNewStaff(GeneralEntity usersEntity) {
        doPost("users/new",usersEntity);
    }
}
