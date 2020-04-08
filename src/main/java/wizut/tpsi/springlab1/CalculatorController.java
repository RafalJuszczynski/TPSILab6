/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.springlab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {
   
    @RequestMapping("/calculator")
    public String calculator(Model model, Integer x, Integer y) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("wynik", x+y);
    
        return "calculator";
    }
    
    @RequestMapping("/calculator2")
    public String calculator2(Model model, Integer x, Integer y, String znak) {

        Integer wynik=0;
        switch(znak){
            case "-":
                wynik=x-y;
                break;
            case "+":
                wynik=x+y;
                break;
            case "*":
                wynik=x*y;
                break;
            case "/":
                if(x==0 || y==0){
                    wynik=0;
                }else{
                    wynik=x/y;
                }
                break;
            default:
                wynik=0;
                break;
        }
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("znak", znak);
        model.addAttribute("wynik", wynik);
        return "calculator2";
    }
    
    @RequestMapping("/calculator3")
    public String calculator3(Model model, CalculatorForm kalkulator) {
        Integer x=kalkulator.getX();
        Integer y=kalkulator.getY();
        String znak=kalkulator.getZnak();
        Integer wynik=0;
        switch(znak){
            case "-":
                wynik=x-y;
                break;
            case "+":
                wynik=x+y;
                break;
            case "*":
                wynik=x*y;
                break;
            case "/":
                if(x==0 || y==0){
                    wynik=0;
                }else{
                    wynik=x/y;
                }
                break;
            default:
                wynik=0;
                break;
        }
        kalkulator.setWynik(wynik);        
        model.addAttribute("kalkulator", kalkulator);
        return "calculator3";
    }
    
}
