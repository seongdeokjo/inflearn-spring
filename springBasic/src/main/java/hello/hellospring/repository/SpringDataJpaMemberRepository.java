package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// spring data jpa 사용
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {
    // 인터페이스를 통한 기본적인 CRUD
    // 메서드 이름 만으로 조회 기능 제공
    // 페이징 기능 자동 제공
    @Override
    Optional<Member> findByName(String name);
}
