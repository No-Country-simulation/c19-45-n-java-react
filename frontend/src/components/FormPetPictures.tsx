import { BtnUpload } from ".";

export const FormPetPictures = () => {
  return (
    <section className="my-14">
      <h1 className="text-4xl font-semibold mb-6">Visual</h1>
      <div className="grid grid-cols-3 gap-4">
        <BtnUpload label="Subir Foto (1)" />
        <BtnUpload label="Subir Foto (2)" />
        <BtnUpload label="Subir Foto (3)" />
      </div>
    </section>
  );
};
