package actions;

interface Find_Action {
    void findCards(); // Based on your hand, judge all the hands you can interact with
    void checkCard(int n); // Check whether can act to a certain card
    void removeCard(int n); // Remove card(player's action)
}
