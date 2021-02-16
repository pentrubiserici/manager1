package pentrubiserici.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pentrubiserici.manager.model.Member;
import pentrubiserici.manager.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImp implements MemberService {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member getById(long id) {
        return memberRepository.getOne(id);
    }

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void delete(long id) {
        memberRepository.deleteById(id);
    }

}
