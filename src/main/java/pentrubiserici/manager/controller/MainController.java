package pentrubiserici.manager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import pentrubiserici.manager.model.Member;
import pentrubiserici.manager.service.MemberService;

@Controller
class HomeController {


    @Autowired
    MemberService memberService;

    @RequestMapping("/login1")
    public String getlogin() {
        return "loginPage1";
    }

    @RequestMapping(value="/save_member")
    public RedirectView saveMember(final Member newMenberr) {

       memberService.saveMember(newMenberr);

       return new RedirectView("/members/showMembers");
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/addMembers")
    public String addMember(Model model) {

        Member m = new Member("Daniel", "0000123123");
        model.addAttribute("member", m);
        memberService.saveMember(m);


        return "/members/addMembers";
    }


    @RequestMapping("/showMembers")
    public String showMember(Model model) {
        model.addAttribute("membri",  memberService.getAll());
        return "/members/showMembers";
    }


    @RequestMapping("/deleteMember")
    public RedirectView saveMemberdeleteMember(Member member) {

        memberService.delete(member.getId());

        return new RedirectView("showMembers");
    }

}
