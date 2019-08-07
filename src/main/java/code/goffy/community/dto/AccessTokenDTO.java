package code.goffy.community.dto;

import lombok.Data;

/**
 * @Author:Goffy
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
