import { PET_AGES, PET_SEX_ALL, PET_SPECIES_ALL } from "@/constants";
import { Input, Select } from ".";

export const FormPetBasic = () => {
  return (
    <section className="my-14">
      <h1 className="text-4xl font-semibold mb-6">Básico</h1>

      <div className="flex flex-col gap-6">
        <Input label="Nombres*" type="text" placeholder="Ingresar nombres" />
        <Select
          label="Especie*"
          placeholder="Seleccione especie"
          options={PET_SPECIES_ALL}
        />
        <Input label="Raza*" type="text" placeholder="Ingresar raza" />
        <Select
          label="Edad*"
          placeholder="Seleccione edad"
          options={PET_AGES}
        />
        <Select
          label="Sexo*"
          placeholder="Seleccione sexo"
          options={PET_SEX_ALL}
        />
      </div>
    </section>
  );
};
