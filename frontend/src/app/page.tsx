import { ViewPetsWelcome } from "@/modules/pets/views/PetsWelcome";
import CreatePets from "@/modules/pets/views/CreatePets";

const PagePets = () => {
  return (
    <div>
      <ViewPetsWelcome />
      <CreatePets />
    </div>
  );
};

export default PagePets;
