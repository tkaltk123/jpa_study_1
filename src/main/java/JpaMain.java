import entity.MemberEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // 엔티티 매니저 팩토리 생성
        var emf = Persistence.createEntityManagerFactory("jpa_1");
        // 엔티티 매니저 생성
        var em = emf.createEntityManager();
        // 트랜잭션 획득
        var tran = em.getTransaction();
        try {
            tran.begin();
            logic(em);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em) {
        var id = "id1";
        var member = new MemberEntity();
        member.setId(id);
        member.setName("서진");
        member.setAge(24);

        //등록
        em.persist(member);

        //수정
        member.setAge(25);

        //단일 조회
        var findMember = em.find(MemberEntity.class, id);
        System.out.println("findMember = " + findMember.toString());

        //목록 조회
        var members = em.createQuery("select m from MemberEntity m", MemberEntity.class).getResultList();
        System.out.println("members.size = " + members.size());

        //삭제
        em.remove(member);
    }
}
