package infviewer.controller;

/**
 * Namena ovog interfejsa je kreiranje određenih elemenata pomoću šablona <b>Abstract Factory</b> (apstraktna fabrika).
 * Elementi koji se kreiraju pomoću apstraktne fabrike su: {@link Parser}, {@link CRUD} i {@link Validator}. Navedeni elementi
 * predstavljaju takođe interfejse. Klase koje nasleđuju ovaj interfejs su <i>konkretne fabrike</i>. Svaka konkretna fabrika
 * je zadužena da kreira instance <i>konkretnih implementacija</i> interfejsa {@link Parser}, {@link CRUD} i {@link Validator}.
 * @author Tim9.1
 * @version 1.0
 * @see <a href="https://www.oodesign.com/abstract-factory-pattern.html">https://www.oodesign.com/abstract-factory-pattern.html</a>
 */
public interface AbstractFactory {
   
   /**
    * Klasa koja implementira {@code AbstractFactory} interfejs pomoću ove metode kreira instancu klase koja impementira interfejs {@code Parser}.
    * U okviru same metode se kreira objekat za čije instanciranje je zadužena <i>konkretna fabrika</i>.
    * @return Povratna vrednost ove metode je instanca <i>konkretnog parsera</i>. Instanca je prethodno kreirana u metodi.
    * @see infviewer.controller.Parser
    */
   Parser createParser();
   
   /**
    * Klasa koja implementira {@code AbstractFactory} interfejs pomoću ove metode kreira instancu klase koja impementira interfejs {@code CRUD}.
    * U okviru same metode se kreira objekat za čije instanciranje je zadužena <i>konkretna fabrika</i>.
    * @return Povratna vrednost ove metode je instanca <i>konkretne crud klase</i>. Instanca je prethodno kreirana u metodi.
    * @see infviewer.controller.CRUD
    */
   CRUD createCRUD();
   
   /**
    * Klasa koja implementira {@code AbstractFactory} interfejs pomoću ove metode kreira instancu klase koja impementira interfejs {@code Validator}.
    * U okviru same metode se kreira objekat za čije instanciranje je zadužena <i>konkretna fabrika</i>.
    * @return Povratna vrednost ove metode je instanca <i>konkretnog validatora</i>. Instanca je prethodno kreirana u metodi.
    * @see infviewer.controller.Validator
    */
   Validator createValidator();
}