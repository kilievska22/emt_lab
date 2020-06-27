package mk.ukim.finki.organisation.sharedkernel.domain.base;

import com.sun.istack.Nullable;

import java.io.Serializable;

public interface IdentifyableDomainObject<ID extends Serializable> extends DomainObject{
    @Nullable
    ID id();
}
