package com.dku.dandev.repository;

import com.dku.dandev.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    public Member findMemberById(Long id);
}
