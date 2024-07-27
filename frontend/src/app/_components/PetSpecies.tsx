import { PET_SPECIES } from "../_constants";
import { PetFilters } from "./PetFilters";
import { PetKind } from "./PetKind";

export const PetSpecies = () => {
  return (
    <div>
      <PetFilters />
      <div className="flex gap-8 mt-6">
        <PetKind name="Todos" specie={PET_SPECIES.ALL} active />
        <PetKind name="Gato" specie={PET_SPECIES.CAT} />
        <PetKind name="Perro" specie={PET_SPECIES.DOG} />
      </div>
    </div>
  );
};
