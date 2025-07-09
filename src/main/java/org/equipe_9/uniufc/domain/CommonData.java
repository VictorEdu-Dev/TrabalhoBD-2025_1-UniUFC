package org.equipe_9.uniufc.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class CommonData implements Serializable {
    public abstract Long getId();
    @Version
    protected Long version;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Class<?> oClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();

        if (!thisClass.equals(oClass)) return false;

        CommonData that = (CommonData) o;
        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public final int hashCode() {
        return getId() != null ? getId().hashCode() :
                (this instanceof HibernateProxy
                        ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                        : getClass().hashCode());
    }
}
