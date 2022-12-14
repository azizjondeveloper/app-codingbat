package uz.pdp.codingbat.entity.template;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class AbcIntAuditingUserAndTime extends AbcUserAuditing{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
