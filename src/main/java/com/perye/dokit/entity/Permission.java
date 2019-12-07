package com.perye.dokit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.perye.dokit.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "permission")
public class Permission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = {Update.class})
    private Long id;

    @NotBlank
    private String name;

    // 上级类目
    @NotNull
    @Column(name = "pid",nullable = false)
    private Long pid;

    @NotBlank
    private String alias;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;


}
