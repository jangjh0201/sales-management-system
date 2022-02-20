package com.drtrue.global.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Authentication 획득
        Authentication ctx = SecurityContextHolder.getContext().getAuthentication();

        // user정보가 있을 경우 사용자 정보 셋팅
        if (ctx.getPrincipal() instanceof UserDetails userDetails) {
            return Optional.of(userDetails.getUsername());
        } else {
            return Optional.empty();
        }
    }

}
