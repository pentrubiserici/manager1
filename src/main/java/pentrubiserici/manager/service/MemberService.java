package pentrubiserici.manager.service;


import pentrubiserici.manager.model.Member;

import java.util.List;

public interface MemberService {

        public List<Member> getAll();

        public Member getById(long id);

        public void saveMember(Member member);

        public void delete(long id);



}
