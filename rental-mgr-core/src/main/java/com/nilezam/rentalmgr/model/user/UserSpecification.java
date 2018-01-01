package com.nilezam.rentalmgr.model.user;

import com.nilezam.rentalmgr.model.repository.Specification;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

public class UserSpecification {


    public static class MailEqual implements Specification<User, UserEntity> {

        private final String targetUserMail;

        public MailEqual(String targetUserMail) {
            this.targetUserMail = targetUserMail != null ? targetUserMail : StringUtils.EMPTY;
        }


        @Override
        public boolean isSpecifiedBy(User user) {
            return targetUserMail.equals(user.getMail());
        }

        @Override
        public Predicate toPredicate(Root<UserEntity> user, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.equal(user.get(UserEntity.Columns.MAIL
                            .getLabel()),
                    targetUserMail);
        }
    }
}

