import { PET_SEX } from "../_constants";
import { Pet } from "./Pet";
import { PetFoundNumber } from "./PetFoundNumber";

export const PetGrid = () => {
  return (
    <>
      <PetFoundNumber />
      <section className="grid grid-cols-3 gap-12 w-full">
        <Pet name="Gringa" sex={PET_SEX.FEMALE} age={2} />
        <Pet name="Puddie" sex={PET_SEX.MALE} age={2} />
        <Pet name="Monino" sex={PET_SEX.FEMALE} age={2} />
      </section>
    </>
  );
};
