import { Select } from ".";

export const FormPetHealth = () => {
  return (
    <section className="my-14">
      <h1 className="text-4xl font-semibold mb-6">Salud</h1>
      <div className="flex flex-col gap-6">
        <Select
          label="Vacunas al día*"
          placeholder="Seleccione"
          options={[
            {
              value: "yes",
              label: "Si",
            },
            {
              value: "no",
              label: "No",
            },
          ]}
        />
        <Select
          label="Especie*"
          placeholder="Seleccione"
          options={[
            {
              value: "yes",
              label: "Si",
            },
            {
              value: "no",
              label: "No",
            },
          ]}
        />
      </div>
    </section>
  );
};
