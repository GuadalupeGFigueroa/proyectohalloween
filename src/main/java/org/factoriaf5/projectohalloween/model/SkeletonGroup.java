package org.factoriaf5.projectohalloween.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("SKELETON_GROUP")
public class SkeletonGroup extends Villains {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "skeleton_group_id")
    private List<Skeleton> skeletons = new ArrayList<>();

    public SkeletonGroup(int numberOfSkeletons) {
        super(numberOfSkeletons * 10, numberOfSkeletons * 5);
        for (int i = 0; i < numberOfSkeletons; i++) {
            skeletons.add(new Skeleton());
        }
    }

    public SkeletonGroup() {
    }

    public void groupAttack(Aiden player) {
        for (Skeleton skeleton : skeletons) {
            player.setLife_points(player.getLife_points() - skeleton.getAttack_points());
        }
    }

    public void removeDefeatedSkeleton() {
        if (!skeletons.isEmpty()) {
            skeletons.remove(0);
        }
        if (skeletons.isEmpty()) {
            setLife_points(0);
        } else {
            setLife_points(getLife_points() - 10);
        }
    }

    @Override
    public void defeated(Aiden player) {
        player.setScore(player.getScore() + (10 * skeletons.size()));
    }

    public List<Skeleton> getSkeletons() {
        return skeletons;
    }

    public void setSkeletons(List<Skeleton> skeletons) {
        this.skeletons = skeletons;
    }
}