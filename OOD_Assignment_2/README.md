# Overall Assignment – Zoo Simulation
We will simulate a zoo in this assignment, focusing on animals and zoo staff members. The Zoo contains a variety of Animals. Three families of animals are provided for you. You should add a fourth of your choosing. In your solution to modeling the Zoo, you should represent the Animals in a class inheritance hierarchy as follows 

(Animal – Family – Type):
*  Animal
    *  Pachyderm
        *  Rhino, Elephant, Hippo
    *  Feline
        *  Tiger, Lion, Cheetah
    *  Birds
        *  Parrot, Falcon, Owl 
    *  [Custom Animal Family you select]
        *  [Three Animal Types you select]

An Animal has attributes including Name (a string), Size (an enumerated value – small, medium, large, extralarge), and Healthy (a boolean). Animals have methods including sleep, roam, eat, makeSound.

---------------------------------------------------------------

* Each method when called should issue a print statement saying the action has been taken by the specific 
instance of the animal, for instance:
  *  Tammy the Tiger has gone to sleep.
  *  Rita the Rhino is roaming – and charged!
  *  Cory the Cheetah is eating 0 food units.
* sleep is a common method to all the animals.
* roam varies at the family level.
  *  Pachyderms may charge during a roam (25% of the time).
  *  Felines may sleep instead of roaming (50% of the time).
* eat is common to all animals. There is a 10% chance an animal eats no food when fed, and a 10% chance they eat too much.
* makeSound is unique to each type of animal.

---------------------------------------------------------------

The Zoo is made up of Enclosures and a Hospital. There is an Enclosure for each Type of Animal. Enclosures are named for the Type of Animal kept in them. Animals are assigned to an Enclosure if Healthy or to the Hospital if not Healthy. You will need to create appropriate associations to relate Enclosures and the Hospital to the Zoo, and Animals to Enclosures (by Type) or the Hospital.

The Zoo also has Staff. Currently there are two subclasses of Staff, Handlers and Veterinarians. The Zoo will have a Handler assigned to each Family of Animals, and a single Veterinarian assigned to the Hospital.

The Zoo simulation will run for 30 days. There are three unique instances of each Animal Type in all the Enclosures at the beginning of the simulation (and no Animals in the Hospital). Display the start and end of each numbered day in the console.

---------------------------------------------------------------

* In a given day, the Staff will perform the following actions.
    1) wakeAnimals - Each Handler will wake their assigned Animals – when awakened, Animals will makeSound.
    2) feedAnimals - Each Handler will feed their assigned Animals – each Animal will perform an eat action. If an Animal does not eat or eats too much, there is a 50% chance of becoming not Healthy. If the Animal is not Healthy it is moved from the Enclosure to the Hospital (this should be announced).
    3) zooStatus - At this point the Zoo opens for the day, you should display a tabular list of the individual Animals in each Enclosure along with the name of the Handler and a list of individual Animals in the Hospital along with the name of the Veterinarian.
    4) exerciseAnimals - Each Handler will exercise their assigned Animals – each Animal will perform a roam action.
    5) treatAnimals - The Veterinarian will treat sick Animals. Each Animal in the hospital will have a 50% chance of becoming Healthy. If they become Healthy, they will be moved to their normal enclosure.
    6) bedAnimals - Each Handler will bed down their Animals for the evening – each Animal will perform a sleep action.

---------------------------------------------------------------

*  When Staff or Animals perform actions, the appropriate print statements should be sent to the console. For Staff, this may look like:
    *  Felix the Feline Handler is exercising animals. 
    *  Valerie the Vet is treating sick animals.
    *  Tony the Tiger is feeling better and is moving back to its enclosure.

---------------------------------------------------------------

An approach will need to be created to find unique names for Animals and Staff (the names can be unique 
strings, strings with numbers, etc.). This naming method should be used when the Animal or Staff object is 
constructed.
