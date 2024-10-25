package org.factoriaf5.projectohalloween.model;
import java.util.List;

public class Groupskeletons {
    private list <skeleton> skeletons;

    public Groupskeletons(List<skeletons>skeletons){
        this.skeletons =  skeletons;
    
    }
    public void Groupattack(Aiden hero) {
        for (skeleton skeleton : skeletons ) {
        hero.setLife_points(hero.getLife_points()- skeleton.getAttack_points());
    }
    }
    public list<skeleton> getSkeletons() {
        return skeletons;
    }
    public void setSkeletons(list<skeleton> skeletons) {
        this.skeletons = skeletons;
    }
        

}
