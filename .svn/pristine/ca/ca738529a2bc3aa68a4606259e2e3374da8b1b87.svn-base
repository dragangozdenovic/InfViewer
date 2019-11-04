/***********************************************************************
 * Module:  Validator.java
 * Author:  Jovic
 * Purpose: Defines the Interface Validator
 ***********************************************************************/

package infviewer.controller;

import infviewer.editor.controller.JSONValidator;
import infviewer.workspace.controller.RDBValidator;

/**
 * Interfejs koga nasljeđuju metode {@link JSONValidator} i {@link RDBValidator}. 
 * Ima jednu metodu <code>validate</code> koja je tipa <code>boolean</code>, pomoću koje se validira 
 * JSON i RDB. 
 * Metoda  {@code validate} prima jedan parametar tipa <tt>Object</tt>.
 * @author DrGoz
 *
 */
public interface Validator {
	/**
	 * @param objectToValidate  Objekat koji se validira.
	 * @return Vraća <tt>true</tt> ako je validacija uspješna. Vraća <tt>false</tt> ako validacija nije uspješna.
	 */
   boolean validate(Object objectToValidate);
}