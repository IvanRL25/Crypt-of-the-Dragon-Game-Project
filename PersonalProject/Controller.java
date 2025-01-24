//package PersonalProject;

/** 
 * 
 * Identifies the key that is pressed and sets a variable corresponding to the key being pressed
 * to true and false when the key is not pressed
 * 
 * @author Ivan Lopez
 * @version DungeonCrawler Alpha 0.01
 * @since 10/2/2023
 * 
 */

public class Controller {

    public double a, w, s, d, e, enter;
      static boolean E = false;
      static boolean A = false;
      static boolean W = false;
      static boolean S = false;
      static boolean D = false;
      static boolean Enter = false;
      static boolean right = false;
      static boolean left = false;
      static boolean one = false;
      static boolean two = false;
      static boolean three = false;
      static boolean four = false;
      static boolean five = false;
      static boolean CAP = false;
      static boolean Q = false;

    public void tick(Boolean ActionA,Boolean ActionW,Boolean ActionS,Boolean ActionD, Boolean ActionE,Boolean ActionEnter, Boolean ActionLeft, Boolean ActionRight,
     Boolean Action1, Boolean Action2, Boolean Action3, Boolean Action4, Boolean Action5, Boolean ActionCAP, boolean ActionQ){
      if(ActionCAP)
      {
        CAP = true;
      }
      if(ActionQ){
        Q = true;
      }
      if(!ActionQ){
        Q=false;
      }

       if(!ActionCAP)
      {
        CAP = false;
      }
      if(ActionRight)
      {
        right = true;
      }

       if(!ActionRight)
      {
        right = false;
      }
      if(ActionLeft)
      {
        left = true;
      }

       if(!ActionLeft)
      {
        left = false;
      }

      if(ActionEnter)
      {
        Enter = true;
      }

       if(!ActionEnter)
      {
        Enter = false;
      }

      if(ActionE)
      {
        E = true;
      }

      if(!ActionE)
      {
        E = false;
      }

      if(ActionA)
      {
        A = true;
      }

      if(!ActionA)
      {
        A = false;
      }

      if(ActionS)
      {
        S = true;
      }

       if(!ActionS)
      {
        S = false;
      }
       if(ActionW)
      {
        W = true;
      }

       if(!ActionW)
      {
        W = false;
      }
       if(ActionD)
      {
        D = true;
      }
       if(!ActionD)
      {
        D = false;
      }
 
      if(Action1)
      {
        one = true;
      }
       if(!Action1)
      {
        one = false;
      }
      if(Action2)
      {
        two = true;
      }
       if(!Action2)
      {
        two = false;
      }
      if(Action3)
      {
        three = true;
      }
       if(!Action3)
      {
        three = false;
      }
      if(Action4)
      {
        four = true;
      }
       if(!Action4)
      {
        four = false;
      }
      if(Action5)
      {
        five = true;
      }
       if(!Action5)
      {
        five = false;
      }
    }
    
}
