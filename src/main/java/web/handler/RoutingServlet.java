package web.handler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

    @GetMapping("/")
    public String welcome() {
        System.out.println("Welcome ...");
        return "view-welcome";
    }

    @GetMapping("/login")
    public String loginView() {
        System.out.println("login view...");
        return "view-login";
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("login form...");
        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        System.out.println("Username/password/dob: " + username + ", " + password + ", " + dob);

        RedirectView redirectView;
        if (LoginService.login(username, password, dob)) {
            redirectView = new RedirectView("/q1", true);
        } else {
            redirectView = new RedirectView("/login", true);
            redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
        }

        return redirectView;
    }

    @GetMapping("/q1")
    public String q1View() {
        System.out.println("q1 view...");
        return "view-q1";
    }

    @PostMapping("/q1")
    public RedirectView q1(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("q1 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        RedirectView redirectView;
        if (number1.isEmpty()) {
            redirectView = new RedirectView("/q1", true);
            redirectAttributes.addFlashAttribute("message", "Please enter a value for number1.");
        } else if (!isNumeric(number1) || !isNumeric(number2) || !isNumeric(resultUser)) {
            redirectView = new RedirectView("/q1", true);
            redirectAttributes.addFlashAttribute("message", "Please enter numeric values only.");
        } else {
            double calculatedResult = MathQuestionService.q1Addition(number1, number2);
            System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

            if (Double.parseDouble(resultUser) == calculatedResult) {
                redirectView = new RedirectView("/q2", true);
            } else {
                redirectView = new RedirectView("/q1", true);
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            }
        }
        return redirectView;
    }

    @GetMapping("/q2")
    public String q2View() {
        System.out.println("q2 view...");
        return "view-q2";
    }

    @PostMapping("/q2")
    public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("q2 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        RedirectView redirectView;
        if (!isNumeric(number1) || !isNumeric(number2) || !isNumeric(resultUser)) {
            redirectView = new RedirectView("/q2", true);
            redirectAttributes.addFlashAttribute("message", "Please enter numeric values only.");
        } else {
            double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
            System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

            if (Double.parseDouble(resultUser) == calculatedResult) {
                redirectView = new RedirectView("/q3", true);
            } else {
                redirectView = new RedirectView("/q2", true);
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            }
        }
        return redirectView;
    }

    @GetMapping("/q3")
    public String q3View() {
        System.out.println("q3 view...");
        return "view-q3";
    }

    @PostMapping("/q3")
    public RedirectView q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("q3 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        RedirectView redirectView;
        if (!isNumeric(number1) || !isNumeric(number2) || !isNumeric(resultUser)) {
            redirectView = new RedirectView("/q3", true);
            redirectAttributes.addFlashAttribute("message", "Please enter numeric values only.");
        } else {
            double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);
            System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

            if (Double.parseDouble(resultUser) == calculatedResult) {
                redirectView = new RedirectView("/success", true);
            } else {
                redirectView = new RedirectView("/q3", true);
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            }
        }
        return redirectView;
    }
    
    
    @GetMapping("/success")
    public String successView() {
        System.out.println("success view...");
        return "view-success";
    }


    @ExceptionHandler(Exception.class)
    public String handleError(Exception ex) {
        ex.printStackTrace();
        return "error";
    }

    // Method to check if a string is numeric
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
