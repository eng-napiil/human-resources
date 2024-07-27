package HrMS;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HrController {
    private final HrService service;

    public HrController(HrService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String getHomePage(){
        return  "home";
    }

    @GetMapping("/Register")
    public  String getRegister(){
        return "Register";
    }

    @PostMapping("/save")
    public String SaveHrModal(@ModelAttribute HrModel hrModel){
        service.insertHrModal(hrModel);
        return "redirect:/All";
    }

    @GetMapping("/All")
    public String getAll(Model model, @Param("keyword") Long keyword) {
        List<HrModel> list = service.getAllHrModal(keyword);

        model.addAttribute("employees", list);
        model.addAttribute("keyword", keyword);
        return "view";
    }

    @RequestMapping("/delete/{id}")
    public  String deleteHrModal(@PathVariable Long id){
        service.deleteHrModal(id);
        return "redirect:/All";
   }
    @RequestMapping("/Edit/{id}")
    public String UpdateHr(@PathVariable Long id, Model model){
       HrModel hrModel = service.getHrModalById(id);
       model.addAttribute("employs",hrModel);
       return "Edit";
    }
}
