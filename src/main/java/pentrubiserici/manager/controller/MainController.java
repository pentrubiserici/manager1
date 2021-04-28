package pentrubiserici.manager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pentrubiserici.manager.model.Member;
import pentrubiserici.manager.service.MemberService;

@Controller
class MainController {


    @Autowired
    MemberService memberService;

    @RequestMapping("/login1")
    public String getlogin() {
        return "loginPage1";
    }



    @RequestMapping(value = "/save_member")
    public RedirectView saveMember(final Member newMember) {

        memberService.saveMember(newMember);
        return new RedirectView("/members/showMembers");
    }

    @RequestMapping(value = "/register", method= RequestMethod.POST)
    public String processForm(@ModelAttribute(value="member") Member member) {
        return "";
    }



    @RequestMapping("/addMember")
    public String AddMember(Model model){

        Member member = new Member();
        member.setFirstName("newMember");
        saveMember(member);
        return "addMember";
    }


    @RequestMapping("/showMembers")
    public String showMember(Model model) {
        model.addAttribute("membri", memberService.getAll());
        return "/members/showMembers";
    }


    @RequestMapping("/deleteMember")
    public RedirectView saveMemberdeleteMember(Member member) {

        memberService.delete(member.getId());

        return new RedirectView("showMembers");
    }

}
