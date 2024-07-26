import { ViewPetsWelcome } from "@/modules/pets/views/PetsWelcome";
import PetList from "@/modules/pets/views/PetList";

const PagePets = () => {
  return (
    <div>
      <ViewPetsWelcome />
      <PetList />
    </div>
  );
};

export default PagePets;
