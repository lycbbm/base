package com.tencent.bbm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @author bbm
 * user
 */
@Data
@Table(name = "t_user")
@ApiModel("用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 6804082733385252162L;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "id", example = "1", required = false, dataType = "String", hidden = true)
    private Integer id;

    /**
     * username
     */
    @ApiModelProperty(name = "userName", value = "姓名", example = "bbm", required = true, dataType = "String")
    @Column(name = "user_name")
    private String userName;

    /**
     * userAge
     */
    @ApiModelProperty(name = "userAge", value = "年龄", example = "18", required = true, dataType = "int")
    @Column(name = "user_age")
    private Integer userAge;

}
