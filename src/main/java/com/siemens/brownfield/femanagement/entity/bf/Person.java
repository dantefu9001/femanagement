package com.siemens.brownfield.femanagement.entity.bf;

import java.io.Serializable;
import lombok.Data;

/**
 * person
 * @author
 */
@Data
public class Person implements Serializable {
    private Integer id;

    private String personNum;

    private String username;

    private Integer bfUserId;

    private String sex;

    private String phone;

    private String email;

    private String wechat;

    private Integer roleId;

    private String basicDataVersion;

    private Boolean deleted;

    private String salt;

    private Object headImg;

    private String skillLevel;

    private Integer imageId;

    private String level;

    private static final long serialVersionUID = 1L;
}
