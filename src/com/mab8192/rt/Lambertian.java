package com.mab8192.rt;

public class Lambertian extends Material{
    public Vec3 albedo;

    public Lambertian(Vec3 albedo) {
        this.albedo = albedo;
    }

    @Override
    public ScatteredRay scatter(Ray r, Hit hit) {
        Vec3 scatterDir = hit.normal.add(Vec3.randomUnitVector());
        if (scatterDir.nearZero()) {
            scatterDir = hit.normal;
        }
        Ray scattered = new Ray(hit.p, scatterDir.normalize());
        Vec3 attenuation = albedo;
        ScatteredRay result = new ScatteredRay(scattered, attenuation);
        result.valid = true;

        return result;
    }
}
