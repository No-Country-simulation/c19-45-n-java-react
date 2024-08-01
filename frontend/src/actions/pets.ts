import { API } from "@/utils/API";

export const getPets = async () => {
  try {
    const pets = await API.get("/mascotas");

    return {
      isOk: pets.data.status === "SUCCESS",
      pets: pets.data?.data || [],
    };
  } catch (error) {
    return { isOk: false };
  }
};

export const petSpecies = async () => {
  try {
    const species = await API.get("/especies");
    return {
      isOk: species.data.status === "SUCCESS",
      species: species.data?.data || [],
    };
  } catch (error) {
    return {
      isOk: false,
    };
  }
};

export const petById = async (id: number) => {
  try {
    const pet = await API.get(`/mascotas/${id}`);

    return {
      isOk: pet.data.status === "SUCCESS",
      pet: pet.data?.data || [],
    };
  } catch (error) {
    return { isOk: false };
  }
};
