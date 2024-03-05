package cosmiccards;

// Define a subclass for Dragoon Transformation
public class DragoonTransformation extends Card {
    private Card originalCard;

    public DragoonTransformation(Card originalCard) {
        super(originalCard.getName() + " (Dragoon)", originalCard.getCardElement(), originalCard.getAVCCID());
        this.originalCard = originalCard;
    }

    // Method to transform the card into Dragoon form
    @Override
    public void transformToDragoon() {
        // Implement transformation logic here
        // For example, change attack values, abilities, etc.
        System.out.println(getName() + " transformation logic applied!");
    }
    public boolean shouldTransformToDragoon() {
        String avccid = getAVCCID();
        // Check if the AVCCID matches any of the Dragoon transformation candidates
        return avccid.equals("7A75") || avccid.equals("A647") || ... ; // Add more AVCCIDs as needed
    }
    // Modify the DragoonTransformation class to use the CardLogger for AVCCID retrieval
        private Card originalCard;
        private CardLog cardLog;

        public DragoonTransformation(Card originalCard, CardLog cardLog) {
            super(originalCard.getName() + " (Dragoon)", originalCard.getElement(), originalCard.getAVCCID());
            this.originalCard = originalCard;
            this.cardLog = cardLog;
        }

        @Override
        public void transformToDragoon() {
            System.out.println(getName() + " transformation logic applied!");
        }

        public boolean shouldTransformToDragoon() {
            String avccid = getAVCCID();
            // Retrieve all AVCCIDs from the CardLogger
            List<String> allAVCCIDs = cardLog.getAllAVCCIDs();
            // Check if the AVCCID matches any of the PartyCards AVCCIDs
            return allAVCCIDs.contains(avccid);
        }
    }

