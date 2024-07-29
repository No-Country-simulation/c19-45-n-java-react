import Image from "next/image";

export const PetPictures = () => {
  return (
    <section>
      <h1 className="font-bold text-3xl">Fotografías de Mascota</h1>
      <div className="grid grid-cols-3 gap-8 mt-4">
        {[1, 2, 3].map((n) => (
          <Image
            key={n}
            src="/pet.png"
            width={100}
            height={100}
            alt="Mascota"
            className="shadow-lg w-full h-[240px] object-cover rounded-lg bg-[#FFCD82]"
          />
        ))}
      </div>
    </section>
  );
};
