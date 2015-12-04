
package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.jdesktop.beansbinding.Converter;


/**
 *
 * @author Wolkor
 */
public class ConverterData extends Converter{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    // objeto para tela.
    @Override
    public Object convertForward(Object value) {
        Calendar  c = (Calendar) value;
        return sdf.format(c.getTime());
    }
    // tela para objeto.
    @Override
    public Object convertReverse(Object value) {
       String str = (String) value;
       Calendar c= Calendar.getInstance();
       try
       {
           c.setTime(sdf.parse(str));
           return c;
       }catch (Exception e){
           return null;
       }
    }
}
