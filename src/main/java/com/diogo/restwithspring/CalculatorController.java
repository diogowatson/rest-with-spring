package com.diogo.restwithspring;


import com.diogo.restwithspring.Exceptions.UnsuportedMathOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
        throw  new UnsuportedMathOperation("Please, set a numeric value");
        }

        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value="/division/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw  new UnsuportedMathOperation("Please, set a numeric value");
        }

        Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return division;
    }

    @RequestMapping(value="/deduction/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double deduction(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw  new UnsuportedMathOperation("Please, set a numeric value");
        }

        Double deduction = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return deduction;
    }

    @RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                            @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw  new UnsuportedMathOperation("Please, set a numeric value");
        }

        Double multiplication = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return multiplication;
    }


    private Double convertToDouble(String strNumber){
        if(strNumber == null ) return 0D;
        String number = strNumber.replaceAll(",",".");
        if (isNumeric(number)) return Double.parseDouble(number);

    return 0D;
    }

    private boolean isNumeric(String strNumber){
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",","."); //adapting from USA number style to BR
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
