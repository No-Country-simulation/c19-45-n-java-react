import { PET_SPECIES } from "@/constants";
import { PetFilters } from "./PetFilters";
import { IPetKind, PetKind } from "./PetKind";
import { petSpecies } from "@/actions/pets";

export const PetSpecies = async () => {
  const { isOk, species } = await petSpecies();
  if (isOk) {
    return (
      <div>
        <PetFilters />
        <div className="flex gap-8 mt-6">
          <PetKind name="Todos" specie={PET_SPECIES.ALL} active />
          {species.map((kind: any) => {
            const kindUppercase = kind.nombre?.toUpperCase();

            return (
              <PetKind
                id={kind.id}
                name={kindUppercase === "CAT" ? "Gato" : "Perro"}
                specie={
                  kindUppercase === "CAT" ? PET_SPECIES.CAT : PET_SPECIES.DOG
                }
              />
            );
          })}
        </div>
      </div>
    );
  }
};
