import { BtnUpload, Select, Textarea } from ".";

export const FormContact = () => {
  return (
    <>
      <Select
        label="Genero*"
        placeholder="Seleccione genero"
        options={[
          {
            value: "fem",
            label: "Femenino",
          },
          {
            value: "masc",
            label: "Masculino",
          },
        ]}
      />
      <BtnUpload label="Foto de Perfil (opcional)" />
      <Textarea
        label="Descripción (opcional)"
        placeholder="Ingrese una descripción"
      />
    </>
  );
};
