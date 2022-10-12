package com.dku.dandev.repository;

import com.dku.dandev.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findMemberById(Long id);
    Optional<Member> findMemberByLoginId(String loginId);
}
