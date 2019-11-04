/***********************************************************************
 * Module:  JSONFactory.java
 * Author:  Jovic
 * Purpose: Defines the Class JSONFactory
 ***********************************************************************/

package infviewer.controller;

import infviewer.editor.controller.JSONValidator;
import infviewer.tree.controller.JSONParser;

/**
 * {@inheritDoc}
 */
public class JSONFactory implements AbstractFactory {
   
   public Parser createParser() {
      Parser parser = new JSONParser();
      return parser;
   }
   
   public CRUD createCRUD() {
      return null;
   }
   
   public Validator createValidator() 
   {
      Validator validator = new JSONValidator();
      return validator;
   }
}