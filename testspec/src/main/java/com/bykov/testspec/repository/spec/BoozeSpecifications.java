package com.bykov.testspec.repository.spec;

import com.bykov.testspec.model.Address;
import com.bykov.testspec.model.Booze;
import com.bykov.testspec.model.Country;
import com.bykov.testspec.model.Type;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.Collection;

@UtilityClass
public class BoozeSpecifications{

    public static Specification<Booze> boozeNotInEurope() {
        return (root, query, criteriaBuilder) -> {
            Subquery<Address> addressSubQuery = query.subquery(Address.class);
            Root<Address> address = addressSubQuery.from(Address.class);
            Expression<Collection<Booze>> booze = address.get("booze");
            addressSubQuery.select(address);
            addressSubQuery.where(criteriaBuilder.equal(address.get("productionCountry"), Country.USA), criteriaBuilder.isMember(root, booze));
            return criteriaBuilder.exists(addressSubQuery);
        };
    }

    public static Specification<Booze> hardBooze() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.or(criteriaBuilder.equal(root.get("boozeType"), Type.COGNAC),
                criteriaBuilder.equal(root.get("boozeType"), Type.WHISKEY),
                criteriaBuilder.equal(root.get("boozeType"), Type.VODKA));
    }
}
