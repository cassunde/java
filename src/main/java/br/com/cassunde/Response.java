package br.com.cassunde;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Response {
    String title = "";

    @Override
    public String toString() {
        return "Response{" +
                "title='" + title + '\'' +
                '}';
    }
}
